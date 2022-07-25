import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { debounce } from 'rxjs';
import { ResultService } from 'src/app/services/result.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  rollNo: number;
  score: number;
  dob: Date;
  name: string;


  constructor(private resultService: ResultService, private router: Router) { }

  ngOnInit(): void {
  }

  // submit function to save student record
  onSubmit() {
    const result = {
      rollNo: this.rollNo,
      score: this.score,
      dob: this.dob,
      name: this.name,

    }
    if (result.score > 100) {
      Swal.fire({
        icon: 'error',
        title: 'Score cannot be more than 100!',
        showConfirmButton: true,
      })
    }
    else {
      this.resultService.addRecord(result).subscribe((response) => {

        Swal.fire({
          icon: 'success',
          title: 'Result has been added!',
          showConfirmButton: false,
          timer: 1500
        })
        this.router.navigateByUrl("/teacherDashboard");
      })
    }

  }
  clearFields() {
    this.rollNo = NaN,
      this.score = NaN,
      this.name = ''

  }
  //logout function to logout from current session
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
        this.router.navigateByUrl("/")
        Swal.fire(
          'Action Completed',
          'Successfully logged out.'
        )
      }
    })
  }

}
