import React from 'react'

const ButonAuth = ({title}) => {
  return (
    <button
              type="submit"
              className="cursor-pointer active:scale-95 w-full py-3.5 bg-gradient-to-r from-blue-500 to-purple-600 text-white font-medium rounded-lg hover:shadow-lg hover:shadow-blue-500/30 transition-all duration-300"
            >
              {title}
            </button>
  )
}

export default ButonAuth