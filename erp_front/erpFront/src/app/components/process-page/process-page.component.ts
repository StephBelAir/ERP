import { Component, OnInit } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {ProcessDialogComponent} from "../process-dialog/process-dialog.component";
import {ProcessService} from "../../services/process.service";

@Component({
  selector: 'app-process-page',
  templateUrl: './process-page.component.html',
  styleUrls: ['./process-page.component.scss']
})
export class ProcessPageComponent implements OnInit {

  constructor(private dialog : MatDialog, private processService : ProcessService) { }

  openDialog() {
    this.dialog.open(ProcessDialogComponent, {
      width: '30%'
    });
  }

  getAllProcess() {
    this.processService.getProcess()
      .subscribe({
        next: (res) => {
          console.log(res);
        },
        error: (err) => {
          alert("Error while fetching the Records !!")
        }
      })
  }

  ngOnInit(): void {
    this.getAllProcess()
  }

}
