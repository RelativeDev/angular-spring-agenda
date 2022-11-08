import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Task } from 'src/app/models/task';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ObserversModule } from '@angular/cdk/observers';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  baseUrl = environment.baseUrl

  constructor(private http: HttpClient, private snack: MatSnackBar) { }

  findAll(): Observable<Task[]> {
    return this.http.get<Task[]>(this.baseUrl);
  }

  findById(id: any): Observable<Task> {
    const url = `${this.baseUrl}/${id}`
    return this.http.get<Task>(url);
  }

  update(task: Task): Observable<Task> {
    const url = `${this.baseUrl}/${task.id}`
    return this.http.put<Task>(url, task);
  }

  delete(id: any): Observable<void> {
    const url = `${this.baseUrl}/${id}`
    return this.http.delete<void>(url);
  }

  create(task: Task): Observable<Task> {
    return this.http.post<Task>(this.baseUrl, task);
  }

  message(msg: string): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
