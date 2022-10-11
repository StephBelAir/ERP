import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LotDialogComponent} from "../lot-dialog/lot-dialog.component";

@Component({
  selector: 'app-lot-page',
  templateUrl: './lot-page.component.html',
  styleUrls: ['./lot-page.component.scss']
})
export class LotPageComponent implements OnInit {

  constructor(private dialog : MatDialog) { }

  ngOnInit(): void {
  }

  openDialog() {
    this.dialog.open(LotDialogComponent, {
      width: '30%'
    });
  }

}
