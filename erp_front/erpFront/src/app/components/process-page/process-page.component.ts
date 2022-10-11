import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {ProcessDialogComponent} from "../process-dialog/process-dialog.component";
import {ProcessService} from "../../services/process.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-process-page',
  templateUrl: './process-page.component.html',
  styleUrls: ['./process-page.component.scss']
})
export class ProcessPageComponent implements OnInit {

  displayedColumns: string[] = ['processId', 'processName'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog : MatDialog, private processService : ProcessService) { }

  ngOnInit(): void {
    this.getAllProcess()
  }

  openDialog() {
    this.dialog.open(ProcessDialogComponent, {
      width: '30%'
    });
  }

  getAllProcess() {
    this.processService.getProcess()
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
