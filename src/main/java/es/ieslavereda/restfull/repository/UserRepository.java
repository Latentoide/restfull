package es.ieslavereda.restfull.repository;

import es.ieslavereda.restfull.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    private static List<User> usuarios;


    public UserRepository() {
        usuarios = new LinkedList<>();
        usuarios.add(new User(1L, "Manolo", "Martinez"));
        usuarios.add(new User(2L, "Luis", "Garcia"));
        usuarios.add(new User(3L, "Carlos", "Sanz"));
    }

    public User findById(long id){
        return usuarios.get((int)id-1);
    }

    public boolean remove(long id) {
        Optional<User> userOptional = usuarios.stream().filter((user) -> user.getId() == id-1).findAny();
        if (userOptional.isPresent()){
            usuarios.remove(userOptional.get());
            return true;
        }
        return false;
    }
}
