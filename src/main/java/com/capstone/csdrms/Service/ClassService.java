package com.capstone.csdrms.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.ClassEntity;
import com.capstone.csdrms.Repository.ClassRepository;

@Service
public class ClassService {
	
	@Autowired
	ClassRepository classRepository;
	
	public List<ClassEntity> getAllClasses(){
		return classRepository.findAll();
	}
	
	 public List<String> getAllSectionsByGrade(int grade) {
	        return classRepository.findAllSectionsByGrade(grade);
	    }
	 public List<Integer> getAllUniqueGrades(){
		 return classRepository.findAllUniqueGrades();
	 }
	
	public ClassEntity insertClass(ClassEntity classEntity) {
		return classRepository.save(classEntity);
	}
	

	public ClassEntity updateClass(Long classId, ClassEntity newClass) {
		Optional<ClassEntity> classEntityOptional = classRepository.findById(classId);
		
		if (classEntityOptional.isPresent()) {
			ClassEntity classEntity = classEntityOptional.get();
			classEntity.setGrade(newClass.getGrade());
			classEntity.setSection(newClass.getSection());
			return classRepository.save(classEntity);
		} else {
			throw new NoSuchElementException("Class with id " + classId + " not found");
		}
	}
	
	public void deleteClass(Long classId) {
		Optional<ClassEntity> classEntityOptional = classRepository.findById(classId);
		
		if (classEntityOptional.isPresent()) {
			classRepository.deleteById(classId);
		} else {
			throw new NoSuchElementException("Class with id " + classId + " not found");
		}
	}
}
