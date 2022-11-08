import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Task } from 'src/app/models/task';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {

  closed = 0;

  list: Task[] = [];
  listFinished: Task[] = [];

  constructor(private service: TaskService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((resposta) => {
      resposta.forEach(task => {
        if (task.finalizado) {
          this.listFinished.push(task);
        }
        else {
          this.list.push(task);
        }
      })
      this.closed = this.listFinished.length;
    })
  }

  delete(id: any): void {
    this.service.delete(id).subscribe((resposta) => {
      if (resposta === null) {
        this.service.message('Task deletada com sucesso!');
        this.list = this.list.filter(task => task.id !== id);
      }
    })
  }

  navegarParaFinalizados(): void {
    this.router.navigate(['finalizados'])
  }

  finalizar(item: Task): void {
    item.finalizado = true;
    this.service.update(item).subscribe(() => {
      this.service.message('Task finalizada com sucesso!');
      this.list = this.list.filter(task => task.id !== item.id);
      this.closed++;
    });
  }

}
