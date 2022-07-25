import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { StudentService } from './services/student.service';



@Injectable({
  providedIn: 'root'
})

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private studentService: StudentService, private router: Router) { }

  canActivate(): boolean {
    if (this.studentService.loggedIn()) {
      return true;
    }
    else {
      this.router.navigateByUrl("/");
      return false;
    }
  }
}




