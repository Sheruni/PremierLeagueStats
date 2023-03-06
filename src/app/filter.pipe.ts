import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  searchName = "";

load() {
    this.searchName = Object.assign({}, this.searchName);
}

  transform(items: any[], searchName: string): any{
    if(searchName===""){
      return items;
    }
    
  return items.filter(match => (match.date.day+"/"+ match.date.month+"/"+ match.date.year).indexOf(searchName) !== -1)
  //The list/table will be filtered according to the date entered as searchName
  }
}
