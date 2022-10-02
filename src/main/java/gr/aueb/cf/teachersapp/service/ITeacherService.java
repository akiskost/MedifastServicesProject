package gr.aueb.cf.teachersapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.teachersapp.dto.TeacherDTO;
import gr.aueb.cf.teachersapp.model.Teacher;
import gr.aueb.cf.teachersapp.service.exceptions.TeacherIdAlreadyExistsException;
import gr.aueb.cf.teachersapp.service.exceptions.TeacherNotFoundException;

public interface ITeacherService {
	
	/**
	 * Inserts a {@link Teacher} based on the data carried by the {@link TeacherDTO}.
	 * 
	 * @param teacherDTO
	 * 			DTO object that contains the data
	 * 
	 * @throws TeacherIdAlreadyExistsException
	 * 			if any teacher, identified by their id, needed to be inserted
	 * 			has already been inserted 
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertTeacher(TeacherDTO teacherDTO) 
			throws SQLException;
	
	
	
	/**
	 * Removes a {@link Teacher} based on the data carried by the {@link TeacherDTO}.
	 *  
	 * @param teacherDTO
	 * 			DTO object that contains the data (mainly the id)
	 * @throws TeacherNotFoundException
	 * 			if any teacher, identified by their id, needed to be removed
	 * 			not found 
	 * @throws SQLException
	 * 			if any error happens during SQL delete 
	 */
	void deleteTeacher(TeacherDTO teacherDTO) 
			throws SQLException; // TeacherNotFoundException,

	
	
	/**
	 * Updates a {@link Teacher} based on the data carried by the {@link TeacherDTO}.
	 * 
	 * @param oldTeacherDTO
	 * 			DTO object hat contains the data -mainly the id- of the teacher
	 * 			that will be updated.
	 * @param newTeacherDTO
	 * 			DTO object that contains the data of the new teacher.
	 * @throws TeacherNotFoundException
	 * 			if any teacher, identified by their id, needed to be updated
	 * 			not found 
	 * @throws SQLException
	 * 			if any error happens during SQL update 
	 */			
	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) 
			throws SQLException;  // TeacherNotFoundException
	
	
	/**
	 * Gets back to the caller a list of the {@link Teacher} objects identified
	 * by their lastname or lastaname's initial characters
	 * 
	 * @param lastname
	 * 			a string object that contains the lastnane or the initial letters
	 * 			that lastname starts with. 
	 * @return
	 * 			a list that contains the results of the search, or null if no
	 * 			results are found
	 * @throws SQLException
	 * 			if any error happens during SQL search 
	 */
	List<Teacher> getTeacherByLastname(String lastname) throws SQLException;
	
}
