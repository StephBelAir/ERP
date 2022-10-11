import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LotDialogComponent} from "../lot-dialog/lot-dialog.component";
import {LotService} from "../../services/lot.service";

@Component({
  selector: 'app-lot-page',
  templateUrl: './lot-page.component.html',
  styleUrls: ['./lot-page.component.scss']
})
export class LotPageComponent implements OnInit {

  constructor(private dialog : MatDialog, private lotService : LotService) { }

  ngOnInit(): void {
    this.getAllLots()
  }

  openDialog() {
    this.dialog.open(LotDialogComponent, {
      width: '30%'
    });
  }

  getAllLots() {
    this.lotService.getLot()
      .subscribe({
        next: (res) => {
          console.log(res);
        },
        error: (err) => {
          alert("Error while fetching the Records !!")
        }
      })
  }

}
