import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LotDialogComponent} from "../lot-dialog/lot-dialog.component";
import {LotService} from "../../services/lot.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-lot-page',
  templateUrl: './lot-page.component.html',
  styleUrls: ['./lot-page.component.scss']
})
export class LotPageComponent implements OnInit {

  displayedColumns: string[] = ['id', 'productName', 'length', 'quantity', 'width', 'type' ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

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
          // console.log(res);
          this.dataSource = new MatTableDataSource<any>(res);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort
        },
        error: (err) => {
          alert("Error while fetching the Records !!")
        }
      })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
