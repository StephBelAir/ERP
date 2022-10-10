import { Component, OnInit } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MachineDialogComponent} from "../machine-dialog/machine-dialog.component";


@Component({
  selector: 'app-machine-page',
  templateUrl: './machine-page.component.html',
  styleUrls: ['./machine-page.component.scss']
})
export class MachinePageComponent implements OnInit {

  constructor(private dialog : MatDialog) { }

  openDialog() {
    this.dialog.open(MachineDialogComponent, {
      width: '30%'
    });
  }

  ngOnInit(): void {
  }

}
