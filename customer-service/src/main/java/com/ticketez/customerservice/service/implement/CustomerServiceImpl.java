package com.ticketez.customerservice.service.implement;

import com.ticketez.customerservice.domain.Customer;
import com.ticketez.customerservice.domain.JoinReqDto;
import com.ticketez.customerservice.domain.customer.LoginReqDto;
import com.ticketez.customerservice.domain.jwt.Token;
import com.ticketez.customerservice.exception.CustomerInfoIsExistsException;
import com.ticketez.customerservice.repository.CustomerRepository;
import com.ticketez.customerservice.service.CustomerService;
import com.ticketez.customerservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret.key}")
    private String secret;

    @Override
    @Transactional
    public Long registerCustomer(JoinReqDto joinReqDto) {
        validateCustomerInfo(joinReqDto);
        try {
            // 비밀번호 암호화
            String encodedPassword = passwordEncoder.encode(joinReqDto.getPassword());
            Customer savedCustomer = customerRepository.save(joinReqDto.toEntity(encodedPassword));
            return savedCustomer.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("회원가입중 오류가 발생했습니다.");
        }

    }

    @Override
    public String login(LoginReqDto loginReqDto) {
        // 아이디로 회원 찾기
        Customer findCustomer = retrieveByUsername(loginReqDto.getUsername());
        // 비밀번호 비교
        if(passwordEncoder.matches(loginReqDto.getPassword(), findCustomer.getPassword()))
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        // 토큰 생성
        Token token = JwtUtil.createToken(findCustomer.getId(), findCustomer.getRole(), secret);
        // 리프레쉬 토큰 Redis Store에 저장
        saveRefreshTokenInCache(findCustomer.getId(), token.getRefreshToken());
        // Access Token만 반환
        return token.getAccessToken();
    }


    private Customer retrieveByUsername(String username){
        return customerRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("존재하지 않는 아이디입니다.")
        );
    }

    private void saveRefreshTokenInCache(Long customerId, String refreshToken){
        // Redis Store에 저장.
    }

    // 고객 정보 검증
    private void validateCustomerInfo(JoinReqDto joinReqDto) {
        if (customerRepository.existsByUsername(joinReqDto.getUsername())) {
            throw new CustomerInfoIsExistsException("이미 등록된 아이디입니다.");
        }
        if (customerRepository.existsByPhoneNum(joinReqDto.getPhoneNum())) {
            throw new CustomerInfoIsExistsException("이미 등록된 전화번호입니다.");
        }
        if (customerRepository.existsByEmail(joinReqDto.getEmail())) {
            throw new CustomerInfoIsExistsException("이미 등록된 이메일입니다.");
        }
    }
}
