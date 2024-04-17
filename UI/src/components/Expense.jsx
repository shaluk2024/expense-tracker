
const Expense = ({amount, date, description}) => {
  return (
    <div className='expense-box'>
       <div className='description-box'>
            {description}
       </div>
       <div className='amount-box'>
        <span>{amount}</span>
        <span>{date}</span>
       </div>

    </div>
  )
}

export default Expense