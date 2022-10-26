import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LaunchLotDialogComponent} from "../launch-lot-dialog/launch-lot-dialog.component";
import {EndLotDialogComponent} from "../end-lot-dialog/end-lot-dialog.component";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {LotService} from "../../services/lot.service";
import Swal from 'sweetalert2';


@Component({
  selector: 'app-launch-page',
  templateUrl: './launch-page.component.html',
  styleUrls: ['./launch-page.component.scss']
})
export class LaunchPageComponent implements OnInit {

  displayedColumns: string[] = ['id', 'productName', 'width', 'processName', 'startDate', 'endDate', 'estimateEndDate', 'actualEndDate'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog : MatDialog, private lotService : LotService) { }

  ngOnInit(): void {
    this.getAllLots()
  }

  openDialog() {
    this.dialog.open(LaunchLotDialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(val=>{
      if (val === 'save'){
        this.getAllLots();
      }
    })
  }

  openEndDialog() {
    this.dialog.open(EndLotDialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(val=>{
      if (val === 'saveEndLot'){
         this.getAllLots();
      }
    })
  }

  getAllLots() {
    this.lotService.getLot()
      .subscribe({
        next: (res) => {
          //console.log(res);
          let list:any = [];
          res.forEach((el: any)=>{
            let proc: any = {};
            if(el.process != null){
              proc.processName = el.process.processName;
            }
            proc.id = el.id;
            proc.productName = el.productName;
            proc.width = el.width;
            proc.startDate = el.startDate;
            proc.endDate = el.endDate;
            proc.estimateEndDate = el.estimateEndDate;
            proc.actualEndDate = el.actualEndDate;
            list.push(proc);
          })
          this.dataSource = new MatTableDataSource(list);
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
