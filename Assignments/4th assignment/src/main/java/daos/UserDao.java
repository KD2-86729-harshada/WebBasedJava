/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 5, 2024
 */

package daos;

import java.util.List;

import entities.User;

public interface UserDao extends AutoCloseable {
	List<User> findAll() throws Exception;
	User findById(int id) throws Exception;
	User findByEmail(String email) throws Exception;
	int save(User u) throws Exception;
	int update(User u) throws Exception;
}
