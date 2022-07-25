import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Teacher } from '../models/Teacher';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  constructor(private _http: HttpClient) { }

  addTeacher(teacher: Teacher) {
    return this._http.post("http://localhost:3000/teachers", teacher);
  }

  loggedIn() {
    return !!localStorage.getItem('tokenT');

  }
}
