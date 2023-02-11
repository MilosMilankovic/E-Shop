package com.eshop.services.serviceImpl;

import com.eshop.dto.UserDto;
import com.eshop.entities.User;
import com.eshop.entities.UserRole;
import com.eshop.repositories.UserRepository;
import com.eshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        return null;
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

//    @Override
//    public List<BookDTO> getAll() {
//        List<Book> bookList = bookRepository.findAll();
//        return BookMapper.INSTANCE.bookListToBookDtoList(bookList);
//    }
//
//    @Override
//    public BookDTO getById(long id) {
//        Optional<Book> bookOptional = bookRepository.findById(id);
//        if (bookOptional.isPresent()) {
//            return BookMapper.INSTANCE.entityToDto(bookOptional.get());
//        }
//
//        return null;
//    }
//
//    @Transactional
//    public void delete(Long id) {
//        bookRepository.deleteById(id);
//    }


}
