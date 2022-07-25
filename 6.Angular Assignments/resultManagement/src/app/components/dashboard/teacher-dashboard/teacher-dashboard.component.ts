import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResultService } from 'src/app/services/result.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-teacher-dashboard',
  templateUrl: './teacher-dashboard.component.html',
  styleUrls: ['./teacher-dashboard.component.css']
})
export class TeacherDashboardComponent implements OnInit {
  count: number;
  results: any;
  record = {
    rollNo: NaN,
    name: '',
    dob: {},
    score: NaN,
  }


  constructor(private resultService: ResultService, private navigate: Router) { }

  ngOnInit(): void {
    this.getResults();
  }

  refresh(): void {
    this.getResults();
  }

  // get results of student
  getResults() {
    this.resultService.getAllResult().subscribe((response) => {
      this.results = response;
      this.count = Object.keys(response).length;
    });
  }

  // delete a record
  onDeleteRecord(id: number) {
    Swal.fire({
      title: 'Are you sure?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Delete!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.resultService.deleteRecord(id).subscribe(() => {
          this.refresh();
        });
        Swal.fire(
          'Action Completed',
          'Successfully Deleted!.'
        )
      }
    })
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
        localStorage.setItem('tokenT', '')
        this.navigate.navigateByUrl("/")
        Swal.fire(
          'Action Completed',
          'Successfully logged out.'
        )
      }
    })
  }
}