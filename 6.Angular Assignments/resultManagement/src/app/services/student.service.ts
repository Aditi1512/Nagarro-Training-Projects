import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from '../models/Student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private _http: HttpClient) {
  }

  addStudent(student: Student) {
    return this._http.post("http://localhost:3000/students", student)
  }

  loggedIn() {
    return !!localStorage.getItem('tokenS');

  }
}
