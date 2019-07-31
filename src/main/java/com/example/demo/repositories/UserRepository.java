package com.example.demo.repositories;

        import com.example.demo.model.User;
        import org.apache.ibatis.annotations.*;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface UserRepository {

    @Insert("Insert into UserAPI(UserName, Password,email)" +
            " values(#{username}, #{password}, #{email})")
    @Options(useGeneratedKeys = true)
    boolean save(User user);

    @Select("select UserName,Password,Email from UserAPI where UserName = #{usernameOrEmail}")
    User loadUserByUsernameRepository(String usernameOrEmail);

    @Select("select UserName,Password,Email from UserAPI")
    List<User> getAllUser();

}
