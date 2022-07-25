import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ResultService } from 'src/app/services/result.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class DashboardStudentComponent implements OnInit {

  student: any;
  studentResult: any;

  constructor(private resultService: ResultService, private router: ActivatedRoute, private http: HttpClient, private navigate: Router) { }

  ngOnInit(): void {
    this.resultService.getStudentById(this.router.snapshot.params['id']).subscribe((response =>
      this.student = response


    ));
    this.getAllRecords();
  }
  refresh(): void {
    this.getAllRecords();
  }

  // get result of student
  getAllRecords() {
    this.http.get<any>("http://localhost:3000/result").subscribe(res => {
      const user = res.find((a: any) => {
        return a.rollNo === this.student.rollNo && a.dob === this.student.dob
      });
      if (user) {
        this.studentResult = user;
        console.log(this.studentResult);
      }
      else {
        Swal.fire({
          icon: 'error',
          title: 'Result Not Found',
          showConfirmButton: true,
        })
      }
    });

  }

  // logout from current session
  logout() {
    Swal.fire({
      title: 'Are you sure?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Logout!'
    }).then((result) => {
      if (result.isConfirmed) {
        localStorage.setItem('tokenS', '')
        this.navigate.navigateByUrl("/")
        Swal.fire(
          'Action Completed',
          'Successfully logged out.'
        )
      }
    })
  }
}

