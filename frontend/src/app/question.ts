export class Question {
    id: number;
    type: string;
    question: string;
    action: string;
    answers: Array<string>;
    numberOfVotes: Array<number>;
    selected: Array<number> = [];
    hidden: boolean;
    hiddenResults: boolean;
    active: boolean;
}