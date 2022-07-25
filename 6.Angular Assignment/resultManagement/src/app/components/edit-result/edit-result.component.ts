import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ResultService } from 'src/app/services/result.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-result',
  templateUrl: './edit-result.component.html',
  styleUrls: ['./edit-result.component.css']
})
export class EditResultComponent implements OnInit {

  rollNo: number;
  score: number;
  dob: Date;
  name: string;



  constructor(private resultService: ResultService, private router: ActivatedRoute, private navigate: Router) { }

  ngOnInit(): void {
    this.resultService.getRecordById(this.router.snapshot.params["id"]).subscribe((result: any) => {
      this.rollNo = result.rollNo,
        this.dob = result.dob,
        this.name = result.name,
        this.score = result.score
    })
  }

  // submit function to save updates data
  onSubmit() {
    const result = {
      rollNo: this.rollNo,
      score: this.score,
      dob: this.dob,
      name: this.name
    }
    if (result.score > 100) {
      Swal.fire({
        icon: 'error',
        title: 'Score cannot be more than 100!',
        showConfirmButton: true,
      })
    } else {
      this.resultService.editRecord(this.router.snapshot.params["id"], result).subscribe((response) => {
        Swal.fire({
          icon: 'success',
          title: 'Result has been updated!',
          showConfirmButton: false,
          timer: 1500
        })
        this.navigate.navigateByUrl("/teacherDashboard");
      })
    }
  }

  // function to clear fields
  clearFields() {
    this.rollNo = NaN,
      this.score = NaN,
      this.name = ''

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
