import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Result } from '../models/Result';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  constructor(private http: HttpClient) { }
  addRecord(result: Result) {
    return this.http.post("http://localhost:3000/result", result);
  }

  getAllResult() {
    return this.http.get("http://localhost:3000/result");
  }

  deleteRecord(id: number) {
    return this.http.delete("http://localhost:3000/result/" + id);
  }

  editRecord(id: number, result: Result) {
    return this.http.put("http://localhost:3000/result/" + id, result);
  }

  getRecordById(id: number) {
    return this.http.get("http://localhost:3000/result/" + id);

  }
  getStudentById(id: number) {
    return this.http.get("http://localhost:3000/students/" + id);
  }
}
