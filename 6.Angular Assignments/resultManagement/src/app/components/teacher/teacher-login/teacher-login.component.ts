
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-teacher-login',
  templateUrl: './teacher-login.component.html',
  styleUrls: ['./teacher-login.component.css']
})
export class TeacherLoginComponent implements OnInit {

  password: string;
  username: string;


  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    const teacher = {
      username: this.username,
      password: this.password
    }
    this.http.get<any>(" http://localhost:3000/teachers").subscribe(response => {
      const user = response.find((a: any) => {
        console.log(a)
        return a.username === teacher.username && a.password === teacher.password
      });
      if (user) {
        Swal.fire({
          icon: 'success',
          title: 'Login Successful',
          showConfirmButton: false,
          timer: 1500
        })
        localStorage.setItem("tokenT", response.token);
        this.router.navigateByUrl("/teacherDashboard");
      }
      else {
        Swal.fire({
          icon: 'error',
          title: 'User Not Found',
          showConfirmButton: true,
        })
      }
    }
    )
  }

}
