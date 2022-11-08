import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskService } from 'src/app/services/task.service';
import { Task } from 'src/app/models/task';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  task: Task = {
    titulo: '',
    descricao: '',
    dataFinalizar: new Date(),
    finalizado: false
  }
  constructor(private router: Router, private service: TaskService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.task.id = this.route.snapshot.paramMap.get("id")!
    this.findById();
  }

  findById(): void {
    this.service.findById(this.task.id).subscribe((resposta) => {
      this.task = resposta;
      this.task.dataFinalizar = new Date();
    })
  }

  update(): void {
    this.formataData();
    this.service.update(this.task).subscribe((resposta) => {
      this.service.message('Informações atualizadas com sucesso!');
      this.router.navigate(['']);
    }, err => {
      this.service.message('Falha ao atualizar task!');
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
