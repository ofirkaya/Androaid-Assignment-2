package com.example.studentapp

object StudentRepository {
    private val students = mutableListOf<Student>()

    // Initialize with sample data for testing
    init {
        addStudent(Student("123456", "John Doe", "050-1234567", "Tel Aviv"))
        addStudent(Student("234567", "Jane Smith", "052-9876543", "Jerusalem"))
        addStudent(Student("345678", "Bob Johnson", "054-5555555", "Haifa"))
        addStudent(Student("456789", "Alice Williams", "053-1111111", "Beer Sheva"))
        addStudent(Student("567890", "Charlie Brown", "050-9999999", "Netanya"))
    }

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun getStudents(): List<Student> = students.toList()

    fun getStudent(id: String): Student? = students.find { it.id == id }

    fun updateStudent(updatedStudent: Student) {
        val index = students.indexOfFirst { it.id == updatedStudent.id }
        if (index != -1) {
            students[index] = updatedStudent
        }
    }

    fun deleteStudent(id: String) {
        val iterator = students.iterator()
        while (iterator.hasNext()) {
            val student = iterator.next()
            if (student.id == id) {
                iterator.remove()
                break
            }
        }
    }

    fun toggleStudentCheck(id: String) {
        val student = getStudent(id)
        student?.let {
            val updatedStudent = it.copy(isChecked = !it.isChecked)
            updateStudent(updatedStudent)
        }
    }
}