package gr.aueb.cf.teachersapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.teachersapp.dao.ITeacherDAO;
import gr.aueb.cf.teachersapp.dto.TeacherDTO;
import gr.aueb.cf.teachersapp.model.Teacher;
import gr.aueb.cf.teachersapp.service.exceptions.TeacherNotFoundException;

public class TeacherServiceImpl implements ITeacherService {
	
	private final ITeacherDAO teacherDAO;
	
	public TeacherServiceImpl(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public void insertTeacher(TeacherDTO teacherDTO) throws SQLException {
		
		// Extract dto 
		Teacher teacher = new Teacher();
		teacher.setSname(teacherDTO.getSname());
		teacher.setFname(teacherDTO.getFname());
		
		try {
			teacherDAO.insert(teacher); 
		} catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public void deleteTeacher(TeacherDTO teacherDTO) 
			throws SQLException {  // TeacherNotFoundException
		Teacher teacherToDelete = new Teacher();
		teacherToDelete.setId(teacherDTO.getId());
		//teacherToDelete.setSname(teacherDTO.getSname());
		
		try {
			//if (teacherDAO.getTeachersByLastnane(teacherToDelete.getSname()) != null ) {
			//	teacherToDelete.setId(teacherDAO.getTeachersByLastnane(teacherToDelete.getSname()).get(0).getId());
				teacherDAO.delete(teacherToDelete);
			//} else {
			//	throw new TeacherNotFoundException(teacherToDelete);
			//}
		} catch (SQLException e) {  // TeacherNotFoundException |
			// Log the exception
			throw e;
		}
	}

	@Override
	public void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO)
			throws SQLException {   // TeacherNotFoundException
		
		// extract DTO
		Teacher teacherToUpdate = new Teacher();
		//teacherToUpdate.setSname(oldTeacherDTO.getSname());
		teacherToUpdate.setId(oldTeacherDTO.getId());
		
		Teacher newTeacher = new Teacher();
		newTeacher.setSname(newTeacherDTO.getSname());
		newTeacher.setFname(newTeacherDTO.getFname());
		
		
		// Forward to DAO
		try {
			//if (teacherDAO.getTeachersByLastnane(teacherToUpdate.getSname()) != null ) {
				//teacherToUpdate.setId(teacherDAO.getTeachersByLastnane(teacherToUpdate.getSname()).get(0).getId());
				teacherDAO.update(teacherToUpdate, newTeacher);
			//} else {
				//throw new TeacherNotFoundException(teacherToUpdate);
			//}
		} catch (SQLException e) { //TeacherNotFoundException | 
			// Log the exception
			throw e;
		}
	}

	@Override
	public List<Teacher> getTeacherByLastname(String lastname) throws SQLException {
		try {
			return teacherDAO.getTeachersByLastnane(lastname);
		} catch (SQLException e) {
			throw e;
		}
	}

}