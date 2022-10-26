import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LotDialogComponent} from "../lot-dialog/lot-dialog.component";
import {LotService} from "../../services/lot.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {LotAddProcessDialogComponent} from "../lot-add-process-dialog/lot-add-process-dialog.component";
import Swal from "sweetalert2";

@Component({
  selector: 'app-lot-page',
  templateUrl: './lot-page.component.html',
  styleUrls: ['./lot-page.component.scss']
})
export class LotPageComponent implements OnInit {

  displayedColumns: string[] = ['id', 'productName', 'width', 'processName', 'quantity', 'length', 'type' ];
  dataSource!: MatTableDataSource<any>;
  proc!: any;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog : MatDialog, private lotService : LotService) { }

  ngOnInit(): void {
    this.getAllLots()
  }

  openDialog() {
    this.dialog.open(LotDialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(val=>{
      if (val === 'save'){
        this.getAllLots();
      }
    })
  }

  openAddDialog() {
    this.dialog.open(LotAddProcessDialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(val=>{
      if (val === 'saveProcess'){
        this.getAllLots();
      }
    })
  }

  getAllLots() {
    this.lotService.getLot()
      .subscribe({
        next: (res) => {
          //console.log(res);
//          let proc: any = {};
//          proc.processName = res.process.processName;
          //this.dataSource = new MatTableDataSource(pro);
          this.dataSource = new MatTableDataSource(res);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort
          console.log(res)

        },
        error: (err) => {
          Swal.fire({ title:"Error while fetching the Records !!",
            icon: "error",})        }
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
