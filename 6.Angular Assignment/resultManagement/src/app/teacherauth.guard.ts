import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { TeacherService } from './services/teacher.service';

@Injectable({
  providedIn: 'root'
})
@Injectable()
export class TeacherauthGuard implements CanActivate {

  constructor(private teacherService: TeacherService, private router: Router) { }

  canActivate(): boolean {
    if (this.teacherService.loggedIn()) {
      return true;
    }
    else {
      this.router.navigateByUrl("/");
      return false;
    }
  }
}