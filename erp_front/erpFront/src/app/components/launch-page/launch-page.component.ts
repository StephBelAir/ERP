import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LaunchLotDialogComponent} from "../launch-lot-dialog/launch-lot-dialog.component";
import {EndLotDialogComponent} from "../end-lot-dialog/end-lot-dialog.component";

@Component({
  selector: 'app-launch-page',
  templateUrl: './launch-page.component.html',
  styleUrls: ['./launch-page.component.scss']
})
export class LaunchPageComponent implements OnInit {

  constructor(private dialog : MatDialog) { }

  ngOnInit(): void {
  }

  openDialog() {
    this.dialog.open(LaunchLotDialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(val=>{
      if (val === 'save'){
       // this.getAllProcess();
      }
    })
  }

  openEndDialog() {
    this.dialog.open(EndLotDialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(val=>{
      if (val === 'save'){
        // this.getAllProcess();
      }
    })
  }

}
