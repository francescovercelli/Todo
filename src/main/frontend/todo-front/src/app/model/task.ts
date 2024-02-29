export class Task {
    id: number;
   
    description_: string;

    due_date: Date;
    completed: boolean;

    constructor(id: number, description_: string, due_date: Date,  completed: boolean, catehory_id: number) {
        this.id = id;
        this.description_ = description_;
        this.due_date = due_date;
        this.completed = completed;
    
    }
}
