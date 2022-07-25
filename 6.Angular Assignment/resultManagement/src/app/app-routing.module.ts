import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { AddStudentComponent } from './components/add-student/add-student.component';
import { DashboardStudentComponent } from './components/dashboard/student-dashboard/student-dashboard.component';
import { TeacherDashboardComponent } from './components/dashboard/teacher-dashboard/teacher-dashboard.component';
import { EditResultComponent } from './components/edit-result/edit-result.component';
import { HomeComponent } from './components/home/home.component';
import { StudentLoginComponent } from './components/student/student-login/student-login.component';
import { StudentRegisterComponent } from './components/student/student-register/student-register.component';
import { TeacherLoginComponent } from './components/teacher/teacher-login/teacher-login.component';
import { TeacherRegisterComponent } from './components/teacher/teacher-register/teacher-register.component';
import { TeacherauthGuard } from './teacherauth.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'

  },
  {
    path: "studentLogin",
    component: StudentLoginComponent,
    pathMatch: 'full'
  },
  {
    path: "teacherLogin",
    component: TeacherLoginComponent,
    pathMatch: 'full'
  },
  {
    path: "studentRegistration",
    component: StudentRegisterComponent,
    pathMatch: 'full'
  },
  {
    path: "teacherRegistration",
    component: TeacherRegisterComponent,
    pathMatch: 'full'
  },
  {
    path: "studentDashboard/:id",
    component: DashboardStudentComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: "teacherDashboard",
    component: TeacherDashboardComponent,
    pathMatch: 'full',
    canActivate: [TeacherauthGuard]
  },
  {
    path: "addStudent",
    component: AddStudentComponent,
    pathMatch: 'full',
    canActivate: [TeacherauthGuard]
  },
  {
    path: "editStudentResult/:id",
    component: EditResultComponent,
    pathMatch: 'full',
    canActivate: [TeacherauthGuard]

  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
