import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from 'src/app/models/Student';
import { StudentService } from 'src/app/services/student.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-student-register',
  templateUrl: './student-register.component.html',
  styleUrls: ['./student-register.component.css']
})
export class StudentRegisterComponent implements OnInit {
  rollNo: number;
  dob: Date;


  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log("on submit function");
    const student = {
      rollNo: this.rollNo,
      dob: this.dob
    }
    console.log(student);
    this.studentService.addStudent(student).subscribe(response => {
      Swal.fire({
        icon: 'success',
        title: 'Registration has been successful!',
        showConfirmButton: false,
        timer: 1500
      })
      this.router.navigateByUrl("/studentLogin");

    })
  }
}