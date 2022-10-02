package gr.aueb.cf.teachersapp.service.exceptions;

import gr.aueb.cf.teachersapp.model.Teacher;

public class TeacherIdAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TeacherIdAlreadyExistsException(Teacher teacher) {
		super("Teacher with id = " + teacher.getId() + " already exists");
	}
}

