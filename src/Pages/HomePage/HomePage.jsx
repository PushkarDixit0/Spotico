import React, { useState } from 'react'
import ShowTournaments from '../../Components/ShowTournaments/ShowTournaments'
import Navbar from '../../Components/Navbar/Navbar'

function HomePage() {
  const [searchSport, setSearchSport] = useState("");

  return (
    <div>
        <Navbar setSearchSport={setSearchSport} />
        <ShowTournaments searchSport={searchSport} />
    </div>
  )
}

export default HomePage