import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent implements OnInit {

  rollNo: number;
  dob: Date;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    const student = {
      rollNo: this.rollNo,
      dob: this.dob
    }
    this.http.get<any>("http://localhost:3000/students").subscribe(
      res => {
        const user = res.find((a: any) => {
          return a.rollNo === student.rollNo && a.dob === student.dob
        });
        if (user) {
          Swal.fire({
            icon: 'success',
            title: 'Login Successful',
            showConfirmButton: false,
            timer: 1500
          })
          localStorage.setItem("tokenS", res.token);
          this.router.navigateByUrl("/studentDashboard/" + user.id);
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
