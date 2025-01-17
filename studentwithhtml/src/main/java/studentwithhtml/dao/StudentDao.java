package studentwithhtml.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentwithhtml.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	public void saveStudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	public List<Student> getAllStudents() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select s from Student s");
		return query.getResultList();
	}
	public Student findStudentById(int id) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
//			id is present
			return dbStudent;
		}
		return null;
	}
	public Student deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbStudent);
			entityTransaction.commit();
			return dbStudent;
		}else {
//			id is not present
			return null;
		}
	}
	
	
	public Student updateStudent(int id,Student student) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			student.setId(id);
			entityManager.merge(student);
			entityTransaction.commit();
			return student;
		}else {
//			id is not present
			return null;
		}
	}
	
}
