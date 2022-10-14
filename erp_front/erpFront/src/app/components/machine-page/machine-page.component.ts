import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {MachineDialogComponent} from "../machine-dialog/machine-dialog.component";
import {MachineService} from "../../services/machine.service";
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';


@Component({
  selector: 'app-machine-page',
  templateUrl: './machine-page.component.html',
  styleUrls: ['./machine-page.component.scss']
})
export class MachinePageComponent implements OnInit {

  displayedColumns: string[] = ['machineId', 'productionTime', 'machineName', 'machineType'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private dialog: MatDialog, private machineService: MachineService) { }

  ngOnInit(): void {
    this.getAllMachines()
  }

  openDialog() {
    this.dialog.open(MachineDialogComponent, {
      width: '30%'
    }).afterClosed().subscribe(val=>{
      if (val === 'save'){
        this.getAllMachines();
      }
    })
  }

  getAllMachines() {
    this.machineService.getMachine()
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
