import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Task } from 'src/app/models/task';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  task: Task = {
    titulo: '',
    descricao: '',
    dataFinalizar: new Date(),
    finalizado: false
  }
  
  constructor(private router: Router, private service: TaskService) { }

  ngOnInit(): void {
  }

  create(): void {
    this.formataData();
    this.service.create(this.task).subscribe((resposta) => {
      this.service.message('Task criada com sucesso!')
      this.router.navigate(['']);
    }, err => {
      this.service.message('Falha ao criar task!')
      this.router.navigate(['']);
    });
  }

  cancel(): void {
    this.router.navigate(['']);
  }

  formataData(): void {
    let data = new Date(this.task.dataFinalizar);
    this.task.dataFinalizar = `${data.getDate()}/${data.getMonth() + 1}/${data.getFullYear()}`
  }

}
