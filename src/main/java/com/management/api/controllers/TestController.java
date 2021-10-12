package com.management.api.controllers;

import com.management.api.dao.*;
import com.management.api.models.*;
import com.management.api.services.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private AddressDao addressDao;

      @Autowired
      private TestService testService;

      @Autowired
      private StudentRepository studentRepository;

      @Autowired
      private ProjectRepository projectRepository;

      @Autowired
      private QuestionRepository questionRepository;

     //Logger ..
    private static final Logger log = LoggerFactory.getLogger(TestController.class);



      @GetMapping("/check")
       public ResponseEntity<?> check()
       {
                return ResponseEntity.status(HttpStatus.OK).body(this.testService);
//                return ResponseEntity.status(HttpStatus.OK).build();

       }


//       @PostMapping("/abc")
//       public ResponseEntity<?> test()
//       {
//         Employee e = new Employee("adnan","khan","20");
//
//         Address address = new Address("khategaon");
//
//         e.setAddress(address);
//         this.employeeDao.save(e);
//         return ResponseEntity.status(HttpStatus.OK).build();
//       }

       @PostMapping("/abc123")
       public ResponseEntity<?> test1(@RequestBody Employee employee)
       {
         System.out.println(employee);
         this.employeeDao.save(employee);
         return ResponseEntity.status(HttpStatus.OK).build();
       }

       @GetMapping("/abc121")
      public ResponseEntity<?> test2()
       {
           log.info("Came on the ans_question api");

           Question q = new Question();
            q.setQuestion("what is java");

           Answer ans = new Answer();
           ans.setAnswer("java is a high level programming language");
           ans.setQuestion1(q);
           Answer ans1 = new Answer();
           ans1.setAnswer("with the help of java we can create softwares");
           ans1.setQuestion1(q);
           Answer ans3 = new Answer();
           ans3.setAnswer("with the help of java we can create android applications");
           ans3.setQuestion1(q);

           List<Answer> list = new ArrayList<>();
           list.add(ans);
           list.add(ans1);
           list.add(ans3);
           q.setAnswers(list);

           Question qq = this.questionRepository.save(q);
//           this.answerRepository.save();
           for(Answer i : list)
           {
               this.answerRepository.save(i);
           }




           return ResponseEntity.status(HttpStatus.OK).build();
       }





       @PostMapping("/abc111")
       public ResponseEntity<?> test3()
       {
           log.info("Hit call test3");

           Student s1 = new Student();
           s1.setId(1);
           s1.setStudentName("adnan");
           Student s2 = new Student();
           s1.setId(2);
           s2.setStudentName("kamran");

           Project p1 = new Project();
           Project p2 = new Project();

           p1.setProjectName("chatbot");
           p2.setProjectName("hotel_management");

           List<Student> s = new ArrayList<>();
           List<Project> p = new ArrayList<>();

           s.add(s1);
           s.add(s2);
           p.add(p1);
           p.add(p2);

           s1.setProjects(p);
           p1.setStudents(s);

           for(Student ss : s)
           {
               this.studentRepository.save(ss);
           }

           for(Project pp : p)
           {
               this.projectRepository.save(pp);

           }

           return ResponseEntity.status(HttpStatus.OK).build();



       }


          @GetMapping("/get_question_answer")
          public ResponseEntity<?> getQuestionAnswer()
          {
               List<Question> lis  = this.questionRepository.findAll();
               return ResponseEntity.status(HttpStatus.OK).body(lis);
          }


}
