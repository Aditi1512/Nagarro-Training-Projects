import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { StudentLoginComponent } from './components/student/student-login/student-login.component';
import { TeacherLoginComponent } from './components/teacher/teacher-login/teacher-login.component';
import { StudentRegisterComponent } from './components/student/student-register/student-register.component';
import { TeacherRegisterComponent } from './components/teacher/teacher-register/teacher-register.component';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DashboardStudentComponent } from './components/dashboard/student-dashboard/student-dashboard.component';
import { TeacherDashboardComponent } from './components/dashboard/teacher-dashboard/teacher-dashboard.component';
import { AddStudentComponent } from './components/add-student/add-student.component';
import { EditResultComponent } from './components/edit-result/edit-result.component';
import { StudentService } from './services/student.service';
import { TeacherService } from './services/teacher.service';
import { ResultService } from './services/result.service';
import { AuthGuard } from './auth.guard';
import { TeacherauthGuard } from './teacherauth.guard';






@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    StudentLoginComponent,
    TeacherLoginComponent,
    StudentRegisterComponent,
    TeacherRegisterComponent,
    DashboardStudentComponent,
    TeacherDashboardComponent,
    AddStudentComponent,
    EditResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [StudentService, TeacherService, ResultService, AuthGuard, TeacherauthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
