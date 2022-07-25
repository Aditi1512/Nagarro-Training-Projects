import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TeacherService } from 'src/app/services/teacher.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-teacher-register',
  templateUrl: './teacher-register.component.html',
  styleUrls: ['./teacher-register.component.css']
})
export class TeacherRegisterComponent implements OnInit {

  username: string;
  password: string;
  email: string;

  constructor(private teacherService: TeacherService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log("on submit function");
    const teacher = {
      username: this.username,
      password: this.password,
      email: this.email
    }
    console.log(teacher);
    this.teacherService.addTeacher(teacher).subscribe((response) => {
      console.log("Teacher added!")
      Swal.fire({
        icon: 'success',
        title: 'Registration has been successful!',
        showConfirmButton: false,
        timer: 1500
      })
      this.router.navigateByUrl("/teacherLogin");

    })
  }
}
