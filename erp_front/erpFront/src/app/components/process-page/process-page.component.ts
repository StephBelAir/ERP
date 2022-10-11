import { Component, OnInit } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {ProcessDialogComponent} from "../process-dialog/process-dialog.component";

@Component({
  selector: 'app-process-page',
  templateUrl: './process-page.component.html',
  styleUrls: ['./process-page.component.scss']
})
export class ProcessPageComponent implements OnInit {

  constructor(private dialog : MatDialog) { }

  openDialog() {
    this.dialog.open(ProcessDialogComponent, {
      width: '30%'
    });
  }

  ngOnInit(): void {
  }

}
