package com.example.study.reposiotry;
import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import com.example.study.repository.UserRepository;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;


public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("user4");
        user.setEmail("test_user4@gmail.com");
        user.setPhoneNumber("010-1111-4444");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");
        User newUser = userRepository.save(user);
        System.out.println("newUser : " +newUser);
    }

    @Test
    @Transactional
    public void read() {
        // Optional<User> user = userRepository.findById(4L);
        Optional<User> user = userRepository.findByAccount("user4");

        System.out.println("user read test + 유저가 주문한 상품!");

        user.ifPresent(selectUser -> {
            selectUser.getOrderDetailList().stream().forEach(detail -> {
                // System.out.println(detail.getItemId());
                Item item = detail.getItem();
                System.out.println("상품 정보 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println(item);
            });
        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser-> {
           selectUser.setAccount("pppp");
           selectUser.setUpdatedAt(LocalDateTime.now());
           selectUser.setUpdatedBy("update method");

           userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional // 삭제한후 롤백시키기 옵션 설정
    public void delete() {
        Optional<User> user = userRepository.findById(2L);
        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser-> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 ");
        } else {
            System.out.println("데이터 삭제 데이터 없음");
        }
    }

}
