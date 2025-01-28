function NoteButton({noteName,note})
{
    return <button className={"rounded bg-primary text-white p-4 box"} onClick={()=>{console.log('clicked')}}>
        <h3>{noteName}</h3>
        <br/>
        <p>{note}</p>
        </button>;
}

export default NoteButton;