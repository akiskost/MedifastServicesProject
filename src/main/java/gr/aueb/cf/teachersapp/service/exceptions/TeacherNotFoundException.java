package gr.aueb.cf.teachersapp.service.exceptions;

import gr.aueb.cf.teachersapp.model.Teacher;

public class TeacherNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public TeacherNotFoundException(Teacher teacher) {
		super("Teacher with id = " + teacher.getId() + " was not found");
	}
}
