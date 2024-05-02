
const Expense = ({amount, date, description, currency}) => {
  return (
    <div className='expense-box'>
       <div className='description-box'>
            {description}
       </div>
       <div className='amount-box'>
        <span>{currency} {amount}</span>
        <span>{date}</span>
       </div>

    </div>
  )
}

export default Expense